package com.codetech.focusstudentbackend.api.model.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class CreateDetectorRequest {

    @NotEmpty
    @NotNull
    private String initialState;

    @NotEmpty
    @NotNull
    private String middleState;

    @NotEmpty
    @NotNull
    private String finalState;

    @NotNull
    private Date detectionDate;

    @NotNull
    private Long studentId;

    @NotNull
    private Long lessonId;
}
