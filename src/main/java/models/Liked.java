package models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


    /**
     * いいね　LikedのDTOモデル
     *
     */
    @Table(name = JpaConst.TABLE_LIKED)
    @NamedQueries({
        @NamedQuery(
                name = JpaConst.Q_LIKED_COUNT,
                query = JpaConst.Q_LIKED_COUNT_DEF),
        @NamedQuery(
                name = JpaConst.Q_LIKED_FIND,
                query = JpaConst.Q_LIKED_FIND_DEF)

    })

    @Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
    @Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
    @NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
    @AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
    @Entity

    public class Liked {

        /**
         * id
         */
        @Id
        @Column(name = JpaConst.LIKED_COL_ID)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        /**
         * 日報を登録した従業員
         */
        @ManyToOne
        @JoinColumn(name = JpaConst.LIKED_COL_EMP, nullable = false)
        private Employee employee;

        /**
         * 日報のID（多対多）
         */
        @ManyToOne
        @JoinColumn(name = JpaConst.LIKED_COL_REP, nullable = false)
        private Report report;

        /**
         * 登録日時
         */
        @Column(name = JpaConst.LIKED_COL_CREATED_AT, nullable = false)
        private LocalDateTime createdAt;

        /**
         * 更新日時
         */
        @Column(name = JpaConst.LIKED_COL_UPDATED_AT, nullable = false)
        private LocalDateTime updatedAt;

    }

