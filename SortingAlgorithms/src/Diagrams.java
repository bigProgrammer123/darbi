import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Diagrams extends Thread{
    static int counter = 1;
    //example:
    //List<Long>x = new ArrayList<Long>(Arrays.asList(1L, 2L));
    private String name;
    private List<Long> simpleSortTime, bubbleSortTime, selectionSortTime, mergeSortTime, quickSortTime, shellSortTime, javaSortTime;
    private Map<String, Double> sortTimeAverage;

    public List<Long> getSimpleSortTime() {
        return simpleSortTime;
    }

    public List<Long> getBubbleSortTime() {
        return bubbleSortTime;
    }

    public List<Long> getSelectionSortTime() {
        return selectionSortTime;
    }

    public List<Long> getMergeSortTime() {
        return mergeSortTime;
    }

    public List<Long> getQuickSortTime() {
        return quickSortTime;
    }

    public List<Long> getShellSortTime() {
        return shellSortTime;
    }

    public List<Long> getJavaSortTime() {
        return javaSortTime;
    }

    public String getNameDiagram() {
        return name;
    }

    public void setNameDiagram(String name) {
        this.name = name;
    }

    public Diagrams() {
        simpleSortTime = new ArrayList<Long>();
        bubbleSortTime = new ArrayList<Long>();
        selectionSortTime = new ArrayList<Long>();
        mergeSortTime = new ArrayList<Long>();
        quickSortTime = new ArrayList<Long>();
        shellSortTime = new ArrayList<Long>();
        javaSortTime = new ArrayList<Long>();

        sortTimeAverage = new HashMap<String, Double>();
        setNameDiagram("Diagramma" + counter);
        counter++;
    }

    public HashMap<String, Double> calculateSortTimeAverage() {
        long commonTime = 0;
        double averageTime = 0;

        if (simpleSortTime.size() != 0) {
            for (int i = 0; i < simpleSortTime.size(); i++) {
                commonTime += simpleSortTime.get(i);
            }
            averageTime = commonTime / simpleSortTime.size();
            sortTimeAverage.put("simpleSortTimeAverage", averageTime);
            commonTime = 0;
        }

        if (bubbleSortTime.size() != 0) {
            for (int i = 0; i < bubbleSortTime.size(); i++) {
                commonTime += bubbleSortTime.get(i);
            }
            averageTime = commonTime / bubbleSortTime.size();
            sortTimeAverage.put("bubbleSortTimeAverage", averageTime);
            commonTime = 0;
        }
        if (selectionSortTime.size() != 0) {
            for (int i = 0; i < selectionSortTime.size(); i++) {
                commonTime += selectionSortTime.get(i);
            }
            averageTime = commonTime / selectionSortTime.size();
            sortTimeAverage.put("selectionSortTimeAverage", averageTime);
            commonTime = 0;
        }
        if (mergeSortTime.size() != 0) {
            for (int i = 0; i < mergeSortTime.size(); i++) {
                commonTime += mergeSortTime.get(i);
            }
            averageTime = commonTime / mergeSortTime.size();
            sortTimeAverage.put("mergeSortTimeAverage", averageTime);
            commonTime = 0;
        }
        if (quickSortTime.size() != 0) {
            for (int i = 0; i < quickSortTime.size(); i++) {
                commonTime += quickSortTime.get(i);
            }
            averageTime = commonTime / quickSortTime.size();
            sortTimeAverage.put("quickSortTimeAverage", averageTime);
            commonTime = 0;
        }
        if (shellSortTime.size() != 0) {
            for (int i = 0; i < shellSortTime.size(); i++) {
                commonTime += shellSortTime.get(i);
            }
            averageTime = commonTime / shellSortTime.size();
            sortTimeAverage.put("shellSortTimeAverage", averageTime);
            commonTime = 0;
        }
        if (javaSortTime.size() != 0) {
            for (int i = 0; i < javaSortTime.size(); i++) {
                commonTime += javaSortTime.get(i);
            }
            averageTime = commonTime / javaSortTime.size();
            sortTimeAverage.put("javaSortTimeAverage", averageTime);
            commonTime = 0;
        }
        return (HashMap<String, Double>) sortTimeAverage;
    }


    @Override
    public String toString() {
        return name;
    }
}
