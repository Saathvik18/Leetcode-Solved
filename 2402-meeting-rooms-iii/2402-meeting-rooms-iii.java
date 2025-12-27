class Solution {
    class Pair{
        int a;
        long b;
        Pair(int x,long y){
            a=x;
            b=y;
        }
    }
    public int mostBooked(int n,int[][] meetings){
        Arrays.sort(meetings,(x,y)->Integer.compare(x[0],y[0]));

        int[] rooms=new int[n];

        PriorityQueue<Integer> free=new PriorityQueue<>();

        PriorityQueue<Pair> busy=new PriorityQueue<>((p1,p2)->{
            if(p1.b<p2.b) return -1;
            if(p1.b>p2.b) return 1;
            if(p1.a<p2.a) return -1;
            if(p1.a>p2.a) return 1;
            return 0;
        });

        for(int i=0;i<n;i++) free.add(i);

        for(int i=0;i<meetings.length;i++){
            int s=meetings[i][0];
            int e=meetings[i][1];

            while(!busy.isEmpty() && busy.peek().b<=s){
                free.add(busy.poll().a);
            }

            if(!free.isEmpty()){
                int r=free.poll();
                busy.add(new Pair(r,e));
                rooms[r]++;
            }else{
                Pair p=busy.poll();
                long dur=e-s;
                busy.add(new Pair(p.a,p.b+dur));
                rooms[p.a]++;
            }
        }

        int ans=0;
        for(int i=1;i<n;i++){
            if(rooms[i]>rooms[ans]) ans=i;
        }
        return ans;
    }
}