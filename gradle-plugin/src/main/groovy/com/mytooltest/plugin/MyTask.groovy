package com.mytooltest.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction;

class MyTask extends DefaultTask {

    @TaskAction
    void action() {
        println("action cjw task")
    }
}
