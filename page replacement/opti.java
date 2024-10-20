import java.util.*;

public class opti {

    static boolean search(int frames[], int key) {
        for (int i = 0; i < frames.length; i++) {
            if (frames[i] == key) {
                return true;
            }
        }

        return false;
    }

    static int predict(int pages[], int frame[], int index) {
        int farthest = index, res = -1;
        
        for (int i = 0; i < frame.length; i++) {
            int j;
            for (j = index; j < pages.length; j++) {
                if (frame[i] == pages[j] && j > farthest) {
                    farthest = j;
                    res = i;
                    break;
                } 
            }

            if (j >= pages.length) {
                return i;
            }
        }

        return (res == -1) ? 0 : res;
    }

    static int optimal(int pages[], int frameCap) {
        int hit = 0;
        int index = 0;

        int frames[] = new int[frameCap];

        for (int i = 0; i < pages.length; i++) {
            if (search(frames, pages[i])) {
                hit++;
                continue;
            }

            if (index < frameCap) {
                frames[index++] = pages[i];
            }

            else {
                int j = predict(pages, frames, i + 1);
                frames[j] = pages[i];
            }
        }

        return hit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fr, pg;
        System.out.println("Enter the number of frames");
        fr = scanner.nextInt();

        System.out.println("Enter the no. of pages: ");
        pg = scanner.nextInt();
        int pages[] = new int[pg];

        System.out.println("Enter the Ref string: ");
        for (int i = 0; i < pg; i++) {
            pages[i] = scanner.nextInt();
        }

        int hits = optimal(pages, fr);

        System.out.println("Hits: " + hits);
        System.out.println("Miss: " + (pg - hits));

        scanner.close();

    }
}
