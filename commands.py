# -*- coding: utf-8 -*-
# Here you can create play commands that are specific to the module, and extend existing commands
import os, os.path
import getopt
import sys
import subprocess

if play_command == 'yml:help':
        print "~ Help for logisima-yml module"
        print "~ "
        print
        sys.exit(0)

if play_command == "yml:generate":
        print "~ Generating yml from the database"
        print "~ "
        check_application()
        load_modules()
        do_classpath()
        try:
            # This is the new style to get the extra arg
            do_java('play.modules.yml.YmlExtractor', sys.argv)
        except Exception:
            # For play! < 1.0.3
            do_java('play.modules.yml.YmlExtractor')
        try:
            subprocess.call(java_cmd, env=os.environ)
        except OSError:
            print "Could not execute the java executable, please make sure the JAVA_HOME environment variable is set properly (the java executable should reside at JAVA_HOME/bin/java). "
            sys.exit(-1)
        print
        sys.exit(0)

