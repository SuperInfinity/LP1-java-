import java.util.*;;

public class lru {

    static int pageFaults(int pages[], int n, int frameCap) {
        int pf = 0;
        
        HashSet<Integer> s = new HashSet<>(frameCap);

        HashMap<Integer, Integer> indexes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (s.size() < frameCap) {
                if (!s.contains(pages[i])) {
                    s.add(pages[i]);
                    pf++;
                }

                indexes.put(pages[i], i);
            }
            else {
                if (!s.contains(pages[i])) {
                    int lru = Integer.MAX_VALUE, val = Integer.MIN_VALUE;

                    Iterator<Integer> itr = s.iterator();

                    while (itr.hasNext()) {
                        int tmp = itr.next();
                        if (indexes.get(tmp) < lru) {
                            lru = indexes.get(tmp);
                            val = tmp;
                        }
                    }

                    s.remove(val);
                    indexes.remove(val);

                    s.add(pages[i]);

                    pf++;
                }

                indexes.put(pages[i], i);
            }
        }


        return pf;
    }

    public static void main(String[] args) {
        int n, fr;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of frames: ");
        fr = scanner.nextInt();

        scanner.nextLine();
        
        System.out.println("Enter number of pages: ");
        n = scanner.nextInt();


        int pages[] = new int[n];

        System.out.println("Enter the ref string seperated by spaces: ");
        for (int i = 0; i < n; i++) {
            pages[i] = scanner.nextInt();
        }

        int pf = pageFaults(pages, n, fr);

        System.out.println("Page faultes --> " + pf);
        System.out.println("Page hits --> " + (n - pf));

        scanner.close();
    }
}