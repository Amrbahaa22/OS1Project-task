package GUI;

import static GUI.Data.A;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Vector;
import sun.java2d.loops.ProcessPath;

public class RR
{
    static Vector<paircalc> v=new Vector<paircalc>();
    static ArrayList<pair2> a=new ArrayList<pair2>();
    static int Process[];
    static int Arrival_time[];
    static int Burst_time[]; 
    static int rem_BT[];
    static int WT[];
    static int TAT[];
    static int resp[];
    static int Sum_AVG_W=0;
    static int Sum_AVG_T=0;
    static int Sum_AVG_R=0;
    static double AVG_W=0;
    static double AVG_T=0;
    static double AVG_R=0;
    static int n;
    public RR(ArrayList<pair>a,int numpro,int Quantum)
    {
        printarr(a);
        n=numpro;
        int q=Quantum;
        Sum_AVG_W=0;
        Sum_AVG_T=0;
        Sum_AVG_R=0;
        AVG_W=0;
        AVG_T=0;
        AVG_R=0;
        this.Process=new int[n];
        this.Burst_time=new int[n];
        this.Arrival_time=new int[n];
        for(int i=0;i<n;++i)
        {
            Process[i]=a.get(i).p-1;
            Burst_time[i]=a.get(i).BT;
            Arrival_time[i]=a.get(i).AT;
        }
        this.WT=new int[n];
        this.rem_BT=new int[n];
        this.TAT=new int[n];
        this.resp=new int[n];
        CalcWaitingTime(n,q);
        for(int i=0;i<n;++i)
        {
                WT[i] = WT[i] - Arrival_time[i];
                TAT[i]=WT[i]+Burst_time[i];
                resp[i]=resp[i]-Arrival_time[i];
                Sum_AVG_W+=WT[i];
                Sum_AVG_T+=TAT[i];
                Sum_AVG_R+=resp[i];
        }
        AVG_W=(double)Sum_AVG_W/n;
        AVG_T=(double)Sum_AVG_T/n;
        AVG_R=(double)Sum_AVG_R/n;
        
        
    }
    private void CalcWaitingTime(int n,int q) {
        paircalc x=new paircalc();
        //x.p=Process[0];
        x.p=0;
        x.BT=Burst_time[0];
        v.add(x);
        int t=0;
        resp[0]=0;
        for(int i=0;i<n;++i) rem_BT[i]=Burst_time[i];
        while(!v.isEmpty())
        {
            
            pair2 x2=new pair2();
            x=new paircalc();
            x=v.get(0);
            v.remove(0);
            x2.start=t;
            if(x.BT>q)
            {
                
                x2.p=x.p;
                if(rem_BT[x.p]==Burst_time[x.p] && x.p!=0)
                {
                    resp[x.p]=t;
                }
                t+=q;
                rem_BT[x.p]-=q;
                x.BT=rem_BT[x.p];
                //WT[x.p]=t-Burst_time[x.p];
                check(x.p,t,n);
            }
            else
            {
                
                x2.p=x.p;
                if(rem_BT[x.p]==Burst_time[x.p] && x.p!=0)
                {
                    resp[x.p]=t;
                }
                t+=rem_BT[x.p];
                WT[x.p] = t -Burst_time[x.p];
                //t = t + rem_BT[x.p];
                rem_BT[x.p] = 0;
                x.BT=0;
                check(x.p,t,n);
            }
            x2.end=t;
            a.add(x2);
            if(rem_BT[x.p]!= 0) 
                v.add(x);
            
        }
    }

    private void check(int p, int t,int n) {
        paircalc e;
        for(int i=p+1;i<n;i++)
        {
            e=new paircalc();
            int f=1;
            for(int j=0;j<v.size();++j)
            {
                e=v.elementAt(j);
                if(e.p==i)
                {
                    f=0;
                    break;
                }
            }
            if((Arrival_time[i]<=t) && (rem_BT[i]!=0)&& (f==1) ) 
            {
                e=new paircalc();
                e.p=i;
                e.BT=rem_BT[i];
                v.add(e);
            }
        }
    }
    public void printarr(ArrayList<pair>a)
    {
        for(int i=0;i<a.size();++i)
        {
            System.out.print(a.get(i).p+"\t\t"+a.get(i).AT+"\t\t"+a.get(i).BT+"\t\t\n");
        }
    }
    public void print()
    {
        System.out.println("RR\n");
        for(int i=0;i<WT.length;++i)
        {
            System.out.print(WT[i]+"\t\t"+TAT[i]+"\t\t"+resp[i]);
            System.out.println("");
        }
        System.out.println(AVG_W);
        System.out.println(AVG_T);
        System.out.println(AVG_R);
        for(int i=0;i<a.size();++i)
        {
            System.out.println("Start: "+a.get(i).start+"processNum"+a.get(i).p+"end: "+a.get(i).end);
        }
         RoundRobinFrame RR=new RoundRobinFrame(a,AVG_W,AVG_T,AVG_R);
         RR.setVisible(true);
    }
    
}