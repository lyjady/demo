package com.example.demo.mapper;

import com.example.demo.entries.Gateway;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LinYongJin
 * @date 2019/8/24 17:42
 */
@Mapper
public interface GatewayMapper {

    @Select("select * from gateway")
    List<Gateway> queryGateway();
}
