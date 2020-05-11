class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int c=image[sr][sc];
        if(image==null||image.length==0||c==newColor)
        {
            return image;
        }
        floodFill(image,sr,sc,newColor,c);
        return image;
        
    }
    public void floodFill(int[][] image, int sr, int sc, int newColor,int c)
    {
        if(!((sr>=image.length||sr<0||sc>=image[0].length||sc<0)||image[sr][sc]!=c))
        {
            image[sr][sc]=newColor;
            floodFill(image,sr+1,sc,newColor,c);
            floodFill(image,sr-1,sc,newColor,c);
            floodFill(image,sr,sc+1,newColor,c);
            floodFill(image,sr,sc-1,newColor,c);
        }
    }
}
