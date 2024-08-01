package com.adobe.prj.orderapp.dao;

import com.adobe.prj.orderapp.dto.ReportDTO;
import com.adobe.prj.orderapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Integer> {

    @Query(value = "select c.email, c.fname, c.lname, o.order_date, o.total   from orders o inner join  customers c on o.customer_fk = c.email", nativeQuery = true)
    List<Object[]> getCustomerAndOrder();

    @Query("select c.email, c.firstName, c.lastName, o.orderDate, o.total from Order o inner join o.customer c")
    List<Object[]> getCustomerAndOrderJPQL();

    @Query("select new com.adobe.prj.orderapp.dto.ReportDTO(c.email, c.firstName, c.lastName, o.orderDate, o.total) from Order o inner join o.customer c where o.oid = :id")
    List<ReportDTO> getReport(@Param("id") int oid);
}
