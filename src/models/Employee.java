package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private String empId;
    private Date dateFrom;
    private Date dateTo;


    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", dateFrom='" + dateFrom + '\'' +
                ", dateTo='" + dateTo + '\'' +
                '}';
    }


    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Employee(String empId, String dateFrom, String dateTo) throws Exception{
        this.empId = empId;
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
        Date date2;
        if(!dateTo.contains("NULL")){
            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateTo);
        } else {
            date2 = new java.util.Date();
        }

        this.dateFrom = date1;
        this.dateTo = date2;
    }
}
