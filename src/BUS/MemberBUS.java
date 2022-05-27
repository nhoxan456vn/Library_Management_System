/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.MemberDAO;
import DTO.MemberDTO;
import java.util.ArrayList;

/**
 *
 * @author Manh Hai
 */
public class MemberBUS {
    private static ArrayList<MemberDTO> arrMember = new ArrayList<>();
    private MemberDAO memberDAO = new MemberDAO();

    public MemberBUS() {
        arrMember = memberDAO.readDB();
    }
    
    public void readDB(){
        arrMember = memberDAO.readDB();
    }
    
    public Boolean add(MemberDTO member){
        Boolean check = memberDAO.add(member);
        if (check){
            arrMember.add(member);
        }
        return check;
    }
    
    public Boolean del(int id){
        Boolean check = memberDAO.del(id);
        if (check){
            for (MemberDTO member : arrMember){
                if (member.getId() == id){
                    arrMember.remove(member);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean upd(MemberDTO member){
        Boolean check = memberDAO.upd(member);  
        if (check){
            for (MemberDTO m : arrMember){
                if (m.getId() == member.getId()){
                    arrMember.set(arrMember.indexOf(m), member);
                    break;
                }
            }
        } 
        return check;
    }
    
    public ArrayList<MemberDTO> getArrMember() {
        readDB();
        return arrMember;
    }
    
    public int getArrSize(){
        return arrMember.size();
    }

    public MemberDTO getMemberByID(int id) {
        for (MemberDTO memberDTO : arrMember) {
            if(memberDTO.getId() == id) {
                return memberDTO;
            }
        }
        return null;
    }
    
    public boolean checkIDexists(int id) {
        return memberDAO.hasID(id);
    }
    
    public ArrayList<MemberDTO> memberListBy(String value) {
        return memberDAO.MemberByName(value);
    }
}
