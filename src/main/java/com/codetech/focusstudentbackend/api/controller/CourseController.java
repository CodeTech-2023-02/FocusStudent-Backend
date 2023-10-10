package com.codetech.focusstudentbackend.api.controller;

import com.codetech.focusstudentbackend.api.model.requests.AddCourseToSection;
import com.codetech.focusstudentbackend.api.model.requests.CreateCourserRequest;
import com.codetech.focusstudentbackend.api.model.requests.CreateSectionRequest;
import com.codetech.focusstudentbackend.api.model.requests.UpdateCourseRequest;
import com.codetech.focusstudentbackend.api.model.responses.MessageResponse;
import com.codetech.focusstudentbackend.api.model.responses.UpdateCourseResponse;
import com.codetech.focusstudentbackend.core.entities.Course;
import com.codetech.focusstudentbackend.core.entities.Section;
import com.codetech.focusstudentbackend.infraestructure.interfaces.ICourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/course")
@AllArgsConstructor
@Tag(name = "Course")
public class CourseController {

    private final ICourseService courseService;
    @Operation(summary = "Create a course")
    @PostMapping()
    public ResponseEntity<MessageResponse> create(@RequestBody CreateCourserRequest request) {
        return ResponseEntity.ok(new MessageResponse(courseService.create(request)));
    }

    @Operation(summary = "Update a course")
    @PutMapping("{courseId}")
    public ResponseEntity<UpdateCourseResponse> addCourseToSection(@PathVariable Long courseId, @RequestBody UpdateCourseRequest request) {
        return ResponseEntity.ok(courseService.update(courseId, request));
    }

    @Operation(summary = "Delete a course")
    @DeleteMapping("{courseId}")
    public ResponseEntity<MessageResponse> addCourseToSection(@PathVariable Long courseId) {
        return ResponseEntity.ok(new MessageResponse(courseService.delete(courseId)));
    }
}