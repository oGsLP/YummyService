package com.xyf.yummy.service.member;

import com.xyf.yummy.entity.Address;
import com.xyf.yummy.model.MemberInfo;
import com.xyf.yummy.model.enums.MemLvEnum;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 15:50
 * @Package: com.xyf.yummy.service.member
 */
public interface MemberManageService {

    /**
     *
     * @param id
     * @return
     */
    MemberInfo getInfo(int id);

    /**
     *
     * @param id
     * @param info
     */
    void modifyInfo(int id, MemberInfo info);


    /**
     *
     * @param id
     * @return
     */
    List<Address> getAddresses(int id);

    /**
     *
     * @param address
     * @return
     */
    boolean addAddress(Address address);

    /**
     *
     * @param mem_id
     * @param address
     * @return
     */
    boolean addAddress(int mem_id, Address address);

    /**
     *
     * @param id
     * @return
     */
    boolean deleteAddress(int id);

    /**
     *
     * @param mem_id
     * @param id
     * @return
     */
    boolean deleteAddress(int mem_id, int id);

    /**
     *
     * @param address
     * @return
     */
    boolean modifyAddress(Address address);


}
