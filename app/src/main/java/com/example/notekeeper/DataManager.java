package com.example.notekeeper;

import android.provider.ContactsContract;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager ourInstance = null;

    private List<CourseInfo> mCourses = new ArrayList<>();
    private List<NoteInfo> mNotes = new ArrayList<>();

    public static DataManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new DataManager();
            ourInstance.initializeCourses();
            ourInstance.initializeExampleNotes();
        }
        return ourInstance;
    }

    public String getCurrentUserName() {
        return "Tianyi";
    }

    public String getCurrentUserEmail() {
        return "tianyi@email.com";
    }

    public List<NoteInfo> getNotes() {
        return mNotes;
    }

    public int createNewNote() {
        NoteInfo note = new NoteInfo(null, null, null);
        mNotes.add(note);
        return mNotes.size() - 1;
    }

    public int findNote(NoteInfo note) {
        for (int index = 0; index < mNotes.size(); index++) {
            if (note.equals(mNotes.get(index)))
                return index;
        }

        return -1;
    }

    public void removeNote(int index) {
        mNotes.remove(index);
    }

    public List<CourseInfo> getCourses() {
        return mCourses;
    }

    public CourseInfo getCourse(String id) {
        for (CourseInfo course: mCourses) {
            if (id.equals(course.getCourseId()))
                return course;
        }
        return null;
    }

    public List<NoteInfo> getNotes(CourseInfo course) {
        ArrayList<NoteInfo> notes = new ArrayList<>();
        for (NoteInfo note:mNotes) {
            if (course.equals(note.getCourse()))
                notes.add(note);
        }
        return notes;
    }

    public int getNoteCount(CourseInfo course) {
        int count = 0;
        for (NoteInfo note: mNotes) {
            if (course.equals(note.getCourse()))
                count++;
        }
        return count;
    }

    private DataManager() {

    }

    //region Initialization code

    public void initializeCourses() {
        mCourses.add(initializeCourse1());
        mCourses.add(initializeCourse2());
        mCourses.add(initializeCourse3());
        mCourses.add(initializeCourse4());
    }

    public void initializeExampleNotes() {
        final DataManager dm = getInstance();

        CourseInfo course  = dm.getCourse("Course1: android_intents");
        course.getModule("android_intents_m01").setComplete(true);
        course.getModule("android_intents_m02").setComplete(true);
        course.getModule("android_intents_m03").setComplete(true);
        mNotes.add(new NoteInfo(course, "Dynamic intent resolution",
                "Wow, intents allow components to be resolved at runtime"));
        mNotes.add(new NoteInfo(course, "Delegating intents",
                "PendingIntents are powerful; they delegate much more than just a component invocation"));

        course = dm.getCourse("Course2: android_async");
        course.getModule("android_async_m01").setComplete(true);
        course.getModule("android_async_m02").setComplete(true);
        mNotes.add(new NoteInfo(course, "Service default threads",
                "Did you know that by default an Android Service will tie up the UI thread?"));
        mNotes.add(new NoteInfo(course, "Delegating intents",
                "Foreground Services can be tied to a notification icon"));

        course = dm.getCourse("Course3: java_lang");
        course.getModule("java_lang_m01").setComplete(true);
        course.getModule("java_lang_m02").setComplete(true);
        course.getModule("java_lang_m03").setComplete(true);
        course.getModule("java_lang_m04").setComplete(true);
        course.getModule("java_lang_m05").setComplete(true);
        course.getModule("java_lang_m06").setComplete(true);
        course.getModule("java_lang_m07").setComplete(true);
        mNotes.add(new NoteInfo(course, "Parameters",
                "Leverage variable-length parameter lists"));
        mNotes.add(new NoteInfo(course, "Anonymous classes",
                "Anonymous classes simplify implementing one-use types"));

        course = dm.getCourse("Course4: java_core");
        course.getModule("java_core_m01").setComplete(true);
        course.getModule("java_core_m02").setComplete(true);
        course.getModule("java_core_m03").setComplete(true);
        mNotes.add(new NoteInfo(course, "Compiler options",
                "The -jar option isn't compatible with the -cp option"));
        mNotes.add(new NoteInfo(course, "Serialization",
                "Remember to include SerialVersionUID to assure version compatibility"));
    }

    private CourseInfo initializeCourse1() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("android_intents_m01", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("android_intents_m02", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("android_intents_m03", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("android_intents_m04", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("android_intents_m05", "Android Late Binding and Intents"));
        return new CourseInfo("Course1: android_intents", "Android Programming with Intents", modules);
    }

    private CourseInfo initializeCourse2() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("android_async_m01", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("android_async_m02", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("android_async_m03", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("android_async_m04", "Android Late Binding and Intents"));
        return new CourseInfo("Course2: android_async", "Android Asnyc Programming and Services", modules);
    }

    private CourseInfo initializeCourse3() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("java_lang_m01", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_lang_m02", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_lang_m03", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_lang_m04", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_lang_m05", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_lang_m06", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_lang_m07", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_lang_m08", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_lang_m09", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_lang_m10", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_lang_m11", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_lang_m12", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_lang_m13", "Android Late Binding and Intents"));
        return new CourseInfo("Course3: java_lang", "Java Fundamentals: The Java Language", modules);
    }

    private CourseInfo initializeCourse4() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("java_core_m01", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_core_m02", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_core_m03", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_core_m04", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_core_m05", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_core_m06", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_core_m07", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_core_m08", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_core_m09", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("java_core_m10", "Android Late Binding and Intents"));
        return new CourseInfo("Course4: java_core", "Java Fundamentals: The Core Platform", modules);
    }
    // end region

}
