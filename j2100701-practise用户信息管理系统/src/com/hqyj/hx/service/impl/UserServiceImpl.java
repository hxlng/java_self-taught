package com.hqyj.hx.service.impl;

import com.hqyj.hx.dao.UserDao;
import com.hqyj.hx.dao.impl.UserDaoImpl;
import com.hqyj.hx.pojo.PageData;
import com.hqyj.hx.pojo.User;
import com.hqyj.hx.service.UserService;

import java.util.List;

/**
 * @author xfy
 * @create 2021-09-01 9:22
 */
public class UserServiceImpl  implements UserService {
    //定义分页变量的默认值
    private static final  int DEFAULT_PAGE_SIZE=2;
    private static final  int DEFAULT_CURRENT_SIZE=1;

    //UserService使用userDao进行功能实现
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAll() {
        return userDao.queryAll();
    }

    @Override
    public boolean addOne(User user) {
        if(user==null){
            return false;
        }
        int affectedRows = userDao.insetOne(user);
        //1>0
        return affectedRows>0;
    }

    @Override
    public boolean removeOne(User user) {
        if(user==null){
            return false;
        }
        int affectedRows = userDao.deleteOne(user);
        //1>0
        return affectedRows>0;
    }

    @Override
    public PageData<User> getAllByPage(int currentPage, int pageSize) {
        //处理异常参数的情况
        if(currentPage<1){
            currentPage=DEFAULT_CURRENT_SIZE;
        }
        if(pageSize<=0){
            pageSize=DEFAULT_PAGE_SIZE;
        }
        PageData<User> pageData = new PageData<>();
        //设置当前页码和每页记录数
        pageData.setCurrentPage(currentPage);
        pageData.setPageSize(pageSize);
        //获取用户总记录数
        int totalSize=userDao.countAll();

        //计算总页数  totalSize/pageSize
        int totalPage=(totalSize%pageSize==0)?(totalSize/pageSize):(totalSize/pageSize+1);
        //判断当前页码超出最大页数的情况
        if(currentPage>totalPage){
            currentPage=totalPage;
        }


        //计算上一页
        int previousPage=1;
        if(currentPage>1){
             previousPage=currentPage-1;
        }
        //计算下一页
        int nextPage=totalPage;
        if(currentPage<totalPage){
            nextPage=currentPage+1;
        }
        //计算startIndex
        int startIndex=(currentPage-1)*pageSize;
        //调用userDao获取当前页的记录信息
        List<User> userList = userDao.queryByPage(startIndex, pageSize);
        //PageDate赋值
        pageData.setPreviousPage(previousPage);
        pageData.setNextPage(nextPage);
        pageData.setTotalPage(totalPage);
        pageData.setTotalSize(totalSize);
        pageData.setData(userList);
        return pageData;
    }

    @Override
    public User getOneById(int userId) {
        return userDao.queryOneById(userId);
    }

    @Override
    public boolean editOne(User user) {
        if(user==null){
            return false;
        }
        int affectedRows = userDao.updateOne(user);
        return affectedRows>0;
    }
}
