package com.kito.testlab3;

import javax.faces.context.FacesContext;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ExecutionBean {
    ArrayList<DataBean> data = new ArrayList<>();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");


    public ExecutionBean()
    {
        // TODO init from DB
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();




        Query q = em.createQuery("select c from Data c");

        List<Data> playerList = q.getResultList();
        for(Data p : playerList) {
            data.add(new DataBean(p.getX(), p.getY(), p.getR(), p.getInside()));
        }

        tx.commit();
        em.close();
    }

    public ArrayList<DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataBean> data) {
        this.data = data;
    }

    public void addData(double x, double y, int r)
    {

    }

    public void submit()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        DataBean data = (DataBean) context.getApplication().createValueBinding("#{data}").getValue(context);
        addData(new DataBean(data));
    }

    public void reset()
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.createQuery("delete from Data").executeUpdate();

        tx.commit();
        em.close();
        data.clear();
    }

    public void addData(DataBean data)
    {
        data.setInside(checkIfInside(data.getX(), data.getY(), data.getR()));
        this.data.add(data);

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Data data1 = new Data(data.getX(), data.getY(), data.getR(), data.isInside());

        em.persist(data1);
        tx.commit();
        em.close();
    }

    private boolean checkIfInside(double x, double y, int r)
    {
        if (x >= 0)
        {
            if (y >= 0)
                return y*y <= r*r - x*x;
            else
                return y >= x * 2 - r;
        }
        else
        {
            if (y >= 0)
                return x >= -r && y*2 <= r;
            else
                return false;
        }
    }

    public String circles()
    {
        return Arrays.toString(data.toArray());
    }
}
