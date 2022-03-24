package actions.views;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



    /**
    * いいねのViewモデル
    *
    */
   @Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
   @Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
   @NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
   @AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)

   public class LikedView {
       /**
        * id
        */
       private Integer id;

       /**
        * 日報を登録した従業員
        */
       private EmployeeView employee;

       /**
        * 日報ID（多対多）
        */
       private ReportView report;

       /**
        * 登録日時
        */
       private LocalDateTime createdAt;

       /**
        * 更新日時
        */
       private LocalDateTime updatedAt;
   }


