package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {

    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }



    public Set<Task> getTasks(String name){
        String lowerKey = name.toLowerCase();
        if(lowerKey.equals("ann")){
            return annsTasks;
        } else if (lowerKey.equals("bobs")) {
            return bobsTasks;
        } else if (lowerKey.equals("carol")) {
            return carolsTasks;
        }else if(lowerKey.equals("all")){
            Set<Task> allTasks = new HashSet<>();
            if(annsTasks != null){
                allTasks.addAll(annsTasks);
            }
            if(bobsTasks != null){
                allTasks.addAll(bobsTasks);
            }
            if(carolsTasks != null){
                allTasks.addAll(carolsTasks);
            }
            if(unassignedTasks != null){
                allTasks.addAll(unassignedTasks);
            }
            return allTasks;
        }
        return new HashSet<>();
    }

    public Set<Task> getUnion(Set<Task> set1, Set<Task> set2){
        Set<Task> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }

    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2){
        Set<Task> intersect = new HashSet<>(set1);
        intersect.retainAll(set2);
        return intersect;
    }

    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2){
        Set<Task> diff = new HashSet<>(set1);
        diff.removeAll(set2);
        return diff;
    }
}
