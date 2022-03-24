package actions;

import java.util.ArrayList;
import java.util.List;

import actions.views.EmployeeConverter;
import actions.views.LikedView;
import actions.views.ReportConverter;
import models.Liked;

//いいねのDTOモデル↔Viewモデルの変換を行うクラス

public class LikedConverter {

    /**
     * ViewモデルのインスタンスからDTOモデルのインスタンスを作成する
     * @param lk LikedViewのインスタンス
     * @return Likedのインスタンス
     */

    public static Liked toModel(LikedView lk) {
        return new Liked(
                lk.getId(),
                EmployeeConverter.toModel(lk.getEmployee()),
                ReportConverter.toModel(lk.getReport()),
                lk.getCreatedAt(),
                lk.getUpdatedAt());
    }

    /**
     * DTOモデルのインスタンスからviewモデルのインスタンスを作成する
     * @param l reportのインスタンス
     * @return ReportViewのインスタンス
     */
    public static LikedView toView(Liked l) {

        if(l == null) {
            return null;
        }

        return new LikedView(
                l.getId(),
                EmployeeConverter.toView(l.getEmployee()),
                ReportConverter.toView(l.getReport()),
                l.getCreatedAt(),
                l.getUpdatedAt());

    }

    /**
     * DTOモデルのリストからVIewモデルのリストを作成する
     * @param List DTOモデルのリスト
     * @return Viewモデルのリスト
     */

    public static List<LikedView>toViewList(List<Liked> list) {
        List<LikedView> evs = new ArrayList<>();

        for(Liked l : list) {
            evs.add(toView(l));
        }

        return evs;
    }

    /**
     * Viewモデルの全フィールドの内容をDTOモデルのフィールドにコピーする
     * @param l DTOモデル（コピー先）
     * @param lk Viewモデル（コピー元）
     */

    public static void copyViewToModel(Liked l, LikedView lk) {
        l.setId(lk.getId());
        l.setEmployee(EmployeeConverter.toModel(lk.getEmployee()));
        l.setReport(ReportConverter.toModel(lk.getReport()));
        l.setCreatedAt(lk.getCreatedAt());
        l.setUpdatedAt(lk.getUpdatedAt());
    }
}
