package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        Team myteam = gradeDB.getMyTeam();
        String[] names = myteam.getMembers();
        float sum = 0.0f;
        for (int i = 0; i < names.length; i++) {
            sum += gradeDB.getGrade(names[i], course).getGrade();
        }
        return sum/ names.length;
    }
}
