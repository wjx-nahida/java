import java.util.Locale;
public class demo3 {
    public static void main(String[] argv)
    {
        int[] score = new int[5];

        AddScore(score,90,45,77,85,31);
        Print(score);

        System.out.printf(Locale.US,"the averge is %d%n",CalculateAverge(score));
        System.out.printf(Locale.US,"the max score is %d%n",CalculateMax(score));
        int[] range = RangeOfScore(score, 67, 98);
        Print(range);

    }
    public static boolean AddScore(int[] score,int... student_score)
    {
        int count = 0;
        for(int s_s : student_score)
        {
            score[count++] = s_s;
        }
        return true;
    }
    public static int CalculateAverge(int[] score)
    {
        int averge = 0;
        int total = 0;
        for(int i = 0;i < score.length;i++)
        {
            total += score[i];
        }
        averge = total / score.length;
        return averge;
    }
    public static int CalculateMax(int[] score)
    {
        int max = 0;
        for(int s : score)
        {
            if(s > max)
                max = s;
        }
        return max;
    }
    public static int[] RangeOfScore(int[] score,int startscore,int endscore)
    {
        int[] range = new int[score.length];
        int count = 0;
        for(int s : score)
        {
            if(s >= startscore && s <= endscore)
                range[count++] = s;
        }
        return range;
    }
    public static void Print(int[] score)
    {
        System.out.printf(Locale.US,"the student score table:%n");
        for(int s : score)
        {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
