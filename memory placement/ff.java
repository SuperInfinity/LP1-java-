import java.util.*;



class MemoryBlock {
    int size;
    boolean isAllocated;
    String processName;

    MemoryBlock(int size) {
        this.size = size;
        this.isAllocated = false;
        this.processName = "";
    }
}

class MemoryManager {
    private List<MemoryBlock> memoryBlocks;

    public MemoryManager(List<MemoryBlock> memoryBlocks) {
        this.memoryBlocks = memoryBlocks;
    }

    public void firstfit(String procString, int reqSize) {
        for (MemoryBlock i : memoryBlocks) {
            if (i.size >= reqSize && !i.isAllocated) {
                i.isAllocated = true;
                i.processName = procString;
                System.out.printf("| %-10s | %-10d | %-10s |\n", procString, reqSize, "Allocated");
                return;
            }
        }

        System.out.printf("| %-10s | %-10d | %-10s |\n", procString, reqSize, "Not Allocated");
    }

    public void displayMem() {
        System.out.println("MEmory Sattus");
        System.out.printf("| %-10s | %-10s |", "Block Size", "Process");
        System.out.println("|---------------|----------------|");
        for (MemoryBlock i : memoryBlocks) {
            System.out.printf("| %-10s | %-10s |\n", i.size,  i.isAllocated ? i.processName : "Free");
        }
    }
}


public class ff {
    public static void main(String[] args) {
        List<MemoryBlock> memoryBlocks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Input memory block sizes
        System.out.print("Enter the number of memory blocks: ");
        int numBlocks = scanner.nextInt();
        for (int i = 0; i < numBlocks; i++) {
            System.out.print("Enter size of memory block " + (i + 1) + ": ");
            int size = scanner.nextInt();
            memoryBlocks.add(new MemoryBlock(size));
        }

        MemoryManager memoryManager = new MemoryManager(memoryBlocks);

        while (true) {
            System.out.print("\nEnter process name (e.g., p1) or 'exit' to quit: ");
            String processName = scanner.next();
            if (processName.equalsIgnoreCase("exit")) break;

            System.out.print("Enter the size of memory request: ");
            int requestSize = scanner.nextInt();

            memoryManager.firstfit(processName, requestSize);
            memoryManager.displayMem();
        }

        scanner.close();
    }
}
