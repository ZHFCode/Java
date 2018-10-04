package basic_class_07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ZHF on 2018/8/25.
 */
public class BestArrage {
    public static class Project {
        private int start;
        private int end;

        public Project(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class MinEndComparator implements Comparator<Project> {
        @Override
        public int compare(Project o1, Project o2) {
            return o1.end-o2.end;
        }
    }

    public static int bestArrange(Project[] projects, int cur) {
        Arrays.sort(projects,new MinEndComparator());
        int res = 0;
        for (int i = 0; i < projects.length; i++) {
            if (cur <= projects[i].end) {
                res++;
                cur = projects[i].end;
            }
        }
        return res;
    }
}
