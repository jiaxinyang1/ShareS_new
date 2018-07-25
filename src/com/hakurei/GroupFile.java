package com.hakurei;

import java.util.Objects;

public class GroupFile {
    private  String  groupId;
    private  String groupFileNumber;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupFileNumber() {
        return groupFileNumber;
    }

    public void setGroupFileNumber(String groupFileNumber) {
        this.groupFileNumber = groupFileNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupFile groupFile = (GroupFile) o;
        return Objects.equals(groupId, groupFile.groupId) &&
                Objects.equals(groupFileNumber, groupFile.groupFileNumber);
    }

}
