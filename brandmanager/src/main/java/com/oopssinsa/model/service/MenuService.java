package com.oopssinsa.model.service;

import com.oopssinsa.model.dao.MenuMapper;
import com.oopssinsa.model.dto.AccountDto;
import com.oopssinsa.model.dto.IbDetailDto;
import com.oopssinsa.model.dto.ObDetailDto;
import com.oopssinsa.model.dto.ProductDto;
import org.apache.ibatis.session.SqlSession;

//import static com.oopssinsa.common.MyBatisTemplate.getSqlSession;
import java.util.List;

import static com.oopssinsa.myBatisTemplate.MyBatisTemplate.getSqlSession;

public class MenuService {
    public int insertProduct(ProductDto productDto) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        try {
            // dao 메세지 전달
//            int result = 0;
//            String str = menuMapper.insertProduct(productDto);
//            System.out.println(str);
            int result = menuMapper.insertProduct(productDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public int ibRequest(IbDetailDto ibDetailDto) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        try {
            int result = menuMapper.ibRequest(ibDetailDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }

    }

    public AccountDto login(String id, String password) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        AccountDto accountDto = menuMapper.login(id, password);
        sqlSession.close();
        return accountDto;
    }

    public List<IbDetailDto> findByUserId(String id) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<IbDetailDto> list = menuMapper.findByUserID(id);
        sqlSession.close();
        return list;
    }

    public int obRequest(ObDetailDto obDetailDto) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        try {
            int result = menuMapper.obRequest(obDetailDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public List<ProductDto> showProduct(long brandId) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<ProductDto> list = menuMapper.showProduct(brandId);
        sqlSession.close();
        return list;
    }
}
