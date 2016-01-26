import java.util.*;

public class PageDisplay {

  //public static void DisplayPages(String[] inputs) {
    //List<String> carryOver = new ArrayList<String>();
    //Set<String> hostMap = new HashSet<String>();
    //int count = 0;
    //for (String input : inputs) {
      //if (count == 12) {
        //System.out.println("New page");
        //hostMap.clear();
        //count = 0;
        //for (String carry : carryOver) {
          //String hostId = carry.split(",")[0];
          //System.out.println(carry);
          //hostMap.add(hostId);
          //count++;
        //}
        //carryOver.clear();
      //}
      //String hostId = input.split(",")[0];
      //if (hostMap.contains(hostId)) {
        //carryOver.add(input);
      //} else {
        //System.out.println(input);
        //hostMap.add(hostId);
        //count++;
      //}
    //}
  //}
 
  public static void DisplayPages(String[] inputs) {
    List<String> list = new ArrayList<>(Arrays.asList(inputs));
    Iterator<String> itr = list.iterator();
    int count = 0;
    Set<String> hostIds = new HashSet<String>();
    while (itr.hasNext()) {
      String line = itr.next();
      String hostId = line.split(",")[0];
      if (!hostIds.contains(hostId)) {
        System.out.println(line);
        itr.remove();
        hostIds.add(hostId);
        count++;
      }
      if (count == 12 || !itr.hasNext()) {
        System.out.println("New page");
        hostIds.clear();
        itr = list.iterator();
        count = 0;
      }
    }
  }
   
  public static void main(String[] args) {
    String[] strs = new String[]{
      "1,28,300.1,SanFrancisco",
      "4,5,209.1,SanFrancisco",
      "20,7,208.1,SanFrancisco",
      "23,8,207.1,SanFrancisco",
      "16,10,206.1,Oakland",
      "1,16,205.1,SanFrancisco",
      "6,29,204.1,SanFrancisco",
      "7,20,203.1,SanFrancisco",
      "8,21,202.1,SanFrancisco",
      "2,18,201.1,SanFrancisco",
      "2,30,200.1,SanFrancisco",
      "15,27,109.1,Oakland",
      "10,13,108.1,Oakland",
      "11,26,107.1,Oakland",
      "12,9,106.1,Oakland",
      "13,1,105.1,Oakland",
      "22,17,104.1,Oakland",
      "1,2,103.1,Oakland",
      "28,24,102.1,Oakland",
      "18,14,11.1,SanJose",
      "6,25,10.1,Oakland",
      "19,15,9.1,SanJose",
      "3,19,8.1,SanJose",
      "3,11,7.1,Oakland",
      "27,12,6.1,Oakland",
      "1,3,5.1,Oakland",
      "25,4,4.1,SanJose",
      "5,6,3.1,SanJose",
      "29,22,2.1,SanJose",
      "30,23,1.1,SanJose"
    };
    DisplayPages(strs);
  }
}
