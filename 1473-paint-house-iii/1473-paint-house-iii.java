class Solution {
int dp[][][]=new int[101][101][101];
public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
    
    for(int p[][]:dp){
        for(int x[]:p)Arrays.fill(x,-1);
    }
    return f(0,houses,cost,m,target,n,-1,dp)==(int)1e9?-1:f(0,houses,cost,m,target,n,-1,dp);
}
public int f(int i,int house[],int cost[][],int m,int target,int n,int prev,int dp[][][]){
    //returned (ie9)to avoid overflow
    if(target<0)return (int)1e9;
    if(i>=m){
        return target==0?0:(int)1e9;
    }
    if(dp[i][target][prev+1]!=-1)return dp[i][target][prev+1];
    int min=(int)1e9;
    // going through all the colours
    for(int j=1;j<=n;j++){
        int take=0;
        //if colour is not done in particular house
        if(house[i]==0){
            //checking if previous colour and current colour not same going to count neighbour
            if(j!=prev){
                take=cost[i][j-1]+f(i+1,house,cost,m,target-1,n,j,dp);
            }
            else{
                //checking if previous colour and current colour same 
                take=cost[i][j-1]+f(i+1,house,cost,m,target,n,j,dp);
            }    
        }
        //not taking the cost just checking the neighbour condition 
        else{
            //checking if previous colour and current colour not same going to count neighbour
            if(house[i]!=prev){
                take=f(i+1,house,cost,m,target-1,n,house[i],dp);
            }
            else{
               //checking if previous colour and current colour same 
                take=f(i+1,house,cost,m,target,n,house[i],dp);
            }
        }
        min=Math.min(min,take);
    }
    return dp[i][target][prev+1]=min;
}
}