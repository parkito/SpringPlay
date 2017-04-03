package com.portal.repository.dao.api;

import com.portal.repository.entities.Group;

/**
 * @author Artem Karnov @date 16.11.2016.
 *         artem.karnov@t-systems.com
 **/
public interface GroupDAO extends GenericDAO<Group, Integer> {
    public Group getGroupByTitle(String title);
}
