package com.nigma.gymwise.GymWise.constants;

public class QueryConstants {

    public static final String userFindEmailDateExpired = "SELECT UP.email FROM UserProfileEntity UP INNER JOIN UserMembershipEntity UM ON UM.userId = UP.idUser LEFT JOIN IaRecommendationEntity IR ON IR.idUser = UP.idUser WHERE UM.active = TRUE AND (IR.dateCreated < CURRENT_DATE OR IR.dateCreated IS NULL)";
    public static final String findDataPlanUser = "SELECT\n" +
            "\tUP.PK_ID_USER,\n" +
            "\tCAST(DATE_PART('year', AGE(CURRENT_DATE, UP.birthdate)) AS int) AS AGE,\n" +
            "\tUM.UM_WEIGHT AS WEIGHT,\n" +
            "\tUPR.GOAL AS GOAL,\n" +
            "\tUPR.LIMITATIONS AS LIMITATION\n" +
            "FROM\n" +
            "\tUSER_PROFILE UP\n" +
            "\tLEFT JOIN USER_PREFERENCES UPR ON UPR.FK_ID_USER = UP.PK_ID_USER\n" +
            "\tINNER JOIN USER_MEASURES UM ON UM.FK_ID_USER = UP.PK_ID_USER\n" +
            "WHERE\n" +
            "\tEMAIL = :email";

    private QueryConstants(){}

}
