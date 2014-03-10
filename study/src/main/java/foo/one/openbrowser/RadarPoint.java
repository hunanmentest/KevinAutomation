package foo.one.openbrowser;

public class RadarPoint{  

     public static void main(String [] args){  

         double [][] point={{3,2},{5,4},{1,0},{4,1}};  
         operFunc(point);  
     }  
     //操作方法  
     public static void operFunc(double[][] point){  
         int line=point.length;  
         //int row=2;  
        //double tmpValue=0;  
         double lengthPos[][]=new double[line][4];  
         double lengthPosAFinal[]=new double[line];  
         for(int i=0;i<line;i++){  
             lengthPosAFinal[i]=pointLength(point,i);  
             //lengthPos[i][2]=tmpValue;  
         }  
         lengthPos=insertSort(point,lengthPosAFinal);  
         for(int i=0;i<line;i++){  
             System.out.println("启点"+lengthPos[i][0]+","+lengthPos[i][1]+  
            		 "քӤ׈ˇ"+lengthPos[i][2]+"  Ǥλ׃ˇ"+(int)lengthPos[i][3]);  
         }  
     }  
     //计算距离方法  
     public static double pointLength(double pos[][],int p){  
         return Math.sqrt((Math.abs(pos[p][0]))*(Math.abs(pos[p][0]))+(Math.abs(pos[p][1]))*(Math.abs(pos[p][1])));  
     }  
     //排序方法，将对应点对应承相应的排位  
     public static double[][] insertSort(double[][] point,double lengthPos[]){  
         double tmpLength=0;  
         int tmpPos=0;  
         double [][] gradeLength=new double [point.length][4];  
         for(int i=0;i<point.length;i++){  
             for(int j=0;j<4;j++){  
                 if(j<=1)  
                     gradeLength[i][j]=point[i][j];  
                 else if(j==2)  
                     gradeLength[i][j]=lengthPos[i];  
                 else  
                     gradeLength[i][j]=i;              
             }  
         }  
         for(int i1=0;i1<lengthPos.length-1;i1++){  
             tmpPos=i1;  
             for(int k=i1+1;k>0;k--){  
                 if(lengthPos[k]<lengthPos[tmpPos]){  
                     tmpLength=lengthPos[k];  
                     lengthPos[k]=lengthPos[tmpPos];  
                     lengthPos[tmpPos--]=tmpLength;  
                 }  
             }  
         }  
         for(int i1=0;i1<lengthPos.length;i1++){  
             for(int j=0;j<lengthPos.length;j++){  
                 if(gradeLength[i1][2]==lengthPos[j])  
                     gradeLength[i1][3]=j;  
             }  
         }  
         return gradeLength;  
     }  
     //解析输入方法  
     public static void inputParseToPoint(String str){  
     }  
 } 
