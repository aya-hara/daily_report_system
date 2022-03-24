package services;

import java.time.LocalDateTime;

import actions.LikedConverter;
import actions.views.EmployeeConverter;
import actions.views.EmployeeView;
import actions.views.LikedView;
import actions.views.ReportConverter;
import actions.views.ReportView;
import models.Liked;

//いいねの操作にかかわる処理を行うクラス

public class LikedService extends ServiceBase {



    public void create(ReportView rv,EmployeeView ev) {
        Liked lk = new Liked();
            LocalDateTime ldt = LocalDateTime.now();
            lk.setCreatedAt(ldt);
            lk.setUpdatedAt(ldt);
            lk.setEmployee(EmployeeConverter.toModel(ev));
            lk.setReport(ReportConverter.toModel(rv));
            createInternal(lk);
        }

    public void remove(LikedView lk) {
            removeInternal(lk);
        }


    private Liked findOneInternal(int id) {
        return em.find(Liked.class, id);
    }

    private void createInternal(Liked lk) {
        em.getTransaction().begin();
        em.persist(lk);
        em.getTransaction().commit();

    }

    /**
     * 日報データを更新する
     * @param lk 日報データ
     */
    private void removeInternal(LikedView lk) {
        em.getTransaction().begin();
        em.remove(LikedConverter.toModel(lk));
        em.getTransaction().commit();

    }

    //public LikedView findOne(ReportView rv,EmployeeView ev) {

    //}

}

