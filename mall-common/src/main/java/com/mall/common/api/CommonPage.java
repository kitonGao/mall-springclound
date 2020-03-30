package com.mall.common.api;

import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @program: mall-springclound
 * @description: 分页数据封装类
 * @author: gaojme
 * @create: 2020-03-30 16:02
 */
public class CommonPage<T> {


    /*第几页*/
    private Integer pageNum;

    /*每页大小*/
    private Integer pageSize;

    /*总页数*/
    private Integer totalPage;

    /*总数*/
    private Long total;

    /*当前对象*/
    private List<T> list;


    /**
     * 将PageHelper分页后的list转为分页信息
     * @param list
     * @param <T>
     * @return
     */
    public static <T> CommonPage<T> turnPage(List<T> list) {
        CommonPage<T> result = new CommonPage<T>();
        PageInfo pageInfo = new PageInfo<T>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }


    /**
     * 将SpringData分页后的list转为分页信息
     * @param page
     * @param <T>
     * @return
     */
    public static <T> CommonPage<T> turnPage(Page<T> page){
        CommonPage<T> result = new CommonPage<T>();
        result.setTotalPage(page.getTotalPages());
        result.setPageNum(page.getNumber());
        result.setPageSize(page.getSize());
        result.setTotal(page.getTotalElements());
        result.setList(page.getContent());
        return result;
    }















    //-----------------------------------------------------------


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
