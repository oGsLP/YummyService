package com.xyf.yummy.service.member;

import com.xyf.yummy.entity.Address;
import com.xyf.yummy.model.MemberInfo;

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
     * @return
     */
    MemberInfo getInfo();

    /**
     *
     * @param info
     * @return
     */
    boolean modifyInfo(MemberInfo info);

    /**
     *
     * @param address
     * @return
     */
    boolean addAddress(Address address);

    /**
     *
     * @param id
     * @return
     */
    boolean deleteAddress(int id);

    /**
     *
     * @param address
     * @return
     */
    boolean modifyAddress(Address address);

}
