import java.util.*;

public class fifo {
    public static void main(String[] args) {
        int no_frames;
        int no_pages;
        int hit = 0;
        int ptr = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of frames: ");
        no_frames = scanner.nextInt();

        int frame[] = new int[no_frames];
        for (int i = 0; i < no_frames; i++) {
            frame[i] = -1;
        }

        System.out.println("Enter the number of Pages: ");
        scanner.nextLine();
        no_pages = scanner.nextInt();

        System.out.println("Enter the Pages: ");

        int page[] = new int[no_pages];

        for (int i = 0; i < no_pages; i++) {
            page[i] = scanner.nextInt();
        }

        for (int i : page) {
            boolean f = false;
            for (int j : frame) {
                if (i == j) {
                    hit++;
                    f = true;
                    break;
                }
            }
            if (!f) {
                frame[ptr] = i;
                ptr = (ptr + 1) % no_frames;
            } 

            for (int x : frame) {
                System.out.print(x + "  ");
            }
            System.out.println(" ");
        }
        System.out.println("hit: " + hit);
        System.out.println("miss: " + (no_pages-hit));

        scanner.close();
    }
    
} 