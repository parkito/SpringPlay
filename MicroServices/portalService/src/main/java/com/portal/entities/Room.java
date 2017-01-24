package com.portal.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Karnov 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
@Entity
@Table(name = "Room")
@NamedQuery(name = "Room.getAll", query = "SELECT r FROM Room r")
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRooms")
    private int idRooms;

    @Basic
    @Column(name = "Title", length = 45)
    private String title;

    @Basic
    @Column(name = "MaxMembers")
    private int maxMembers;



    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Room_has_Grup", joinColumns = {
            @JoinColumn(name = "Room_idRooms")},
            inverseJoinColumns = {@JoinColumn(name = "Grup_idGroups")})
    private List<Grup> grups = new ArrayList<>();


    public Room() {
    }

    public Room(String title, int maxMembers) {
        this.title = title;
        this.maxMembers = maxMembers;
    }

//    public Grup getGrup() {
//        return grup;
//    }
//
//    public void setGrup(Grup grup) {
//        this.grup = grup;
//    }

    //    public List<Grup> getGrup() {
//        return grup;
//    }
//
//    public void addGroup(Grup grup) {
//        if (!grup.contains(grup)) {
//            grup.add(grup);
//        } else throw new DAOException(grup.getTitle() + " already in " + title);
//    }

    public int getIdRooms() {
        return idRooms;
    }

    public void setIdRooms(int idRooms) {
        this.idRooms = idRooms;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Integer getMaxMembers() {
        return maxMembers;
    }

    public void setMaxMembers(Integer maxMembers) {
        this.maxMembers = maxMembers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (idRooms != room.idRooms) return false;
        if (maxMembers != room.maxMembers) return false;
        if (title != null ? !title.equals(room.title) : room.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRooms;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + maxMembers;
        return result;
    }
}
