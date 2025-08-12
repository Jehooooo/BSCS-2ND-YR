public class Solution {
  private String title;
  private String genre;
  private int duration;

  public void title(String title) {
    String title1 = "ME";

  }
  public void genre() {
    String genre1 = "Action";


  }
  public void setDuration(int duration) {
    int duration1 = 60;

  }
  public static void main(String[] args) {
    Solution movie = new Solution();
    movie.title("Inception");
    movie.genre();
    movie.setDuration(60);
    

    System.out.println("Movie Title: " + movie.title);

    

  }
}
