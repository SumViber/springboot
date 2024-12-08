package com.sumvibe.springboot.mapper;

import com.mybatisflex.core.BaseMapper;
import com.sumvibe.springboot.domain.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}
