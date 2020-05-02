package services;

import dao.GroupDao;
import models.Group;
import java.util.List;

public class GroupService {
    private GroupDao GroupDao = new GroupDao();
    public GroupService() {
    }
    public Group findGroup(int id) {
        return GroupDao.findById(id);
    }
    public void saveGroup(Group group) {
        GroupDao.save(group);
    }

    public void deleteGroup(Group group) {
        GroupDao.delete(group);
    }

    public void updateGroup(Group group) {
        GroupDao.update(group);
    }
    public List<Group> findCGroupByName(String name) {
        return GroupDao.findByName(name);
    }
    public List <Group> findAllGroups() {
        return GroupDao.findAllGroup();
    }
    public List <Group> findEqGroups(String string) {return  GroupDao.findAllEq(string);}
}
