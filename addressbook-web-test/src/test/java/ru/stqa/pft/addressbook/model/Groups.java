package ru.stqa.pft.addressbook.model;

import java.util.Set;
public class Groups extends com.google.common.collect.ForwardingSet<GroupData> {

    private Set<GroupData> delegate;
    public Groups(Groups groups) {
        this.delegate = new java.util.HashSet<>(groups.delegate);
    }

    public Groups() {
        this.delegate = new java.util.HashSet<>();
    }

    public Groups(java.util.Collection<GroupData> groups) {
        this.delegate = new java.util.HashSet<GroupData>(groups);
    }

    @Override
    protected Set<GroupData> delegate() {
        return delegate;
    }
    public Groups withAdded(GroupData group){
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }
    public Groups withOut(GroupData group){
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
}
