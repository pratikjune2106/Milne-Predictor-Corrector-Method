class Stack1
{
   private double[] a;
   private int top,m;
   public Stack1(int max)
   {
     m=max;
     a=new double[m];
     top=-1;
   }
   public void push(double key)
   {
     a[++top]=key;
   }
   public double pop()
   {
     return(a[top--]);
   }
}
class Evaluate
{
   public double calculate(String s,double x,double y)
   {
     int n;
     double r=0;
     n=s.length();
     Stack1 a=new Stack1(n);
     for(int i=0;i<n;i++)
     {
       char ch=s.charAt(i);
       if(ch>='0'&&ch<='9')
         a.push((int)(ch-'0'));
       else if(ch==(int)'x')
    	 a.push(x);
       else if(ch==(int)'y')
    	 a.push(y);
       else
       {
         double c=a.pop();
         double d=a.pop();
         switch(ch)
         {
           case '+':r=c+d;
              break;
           case '-':r=d-c;
              break;
           case '*':r=c*d;
              break;
           case '/':r=d/c;
              break;
           case '^':r=Math.pow(c, d);
              break;
           default:r=0;
         }
         a.push(r);
       }
     }
     r=a.pop();
     return(r);
   }
}
