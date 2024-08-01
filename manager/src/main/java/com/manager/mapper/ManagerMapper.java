package com.manager.mapper;

import com.manager.entity.Manager;
import com.manager.entity.VO.ManagerAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ManagerMapper {
    @Select("select manager_id from manager_tb where manager_id = #{managerId} and manager_password = #{managerPassword}")
    String login(ManagerAccount managerAccount);

    @Select("select * from manager_tb where manager_id = #{managerId}")
    Manager singleManager(String managerId);

    @Update("update manager_tb set " +
            "manager_password = #{managerPassword}, " +
            "manager_name = #{managerName}, " +
            "manager_sex = #{managerSex}, " +
            "manager_addtime = #{managerAddtime}, " +
            "manager_phone = #{managerPhone} " +
            "where manager_id = #{managerId }")
    boolean changeManager(Manager manager);

}
