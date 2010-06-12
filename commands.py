# -*- coding: utf-8 -*-

###
 #  This file is part of LogiSima.
 #
 #  LogiSima is free software: you can redistribute it and/or modify
 #  it under the terms of the GNU General Public License as published by
 #  the Free Software Foundation, either version 3 of the License, or
 #  (at your option) any later version.
 #
 #  LogiSima is distributed in the hope that it will be useful,
 #  but WITHOUT ANY WARRANTY; without even the implied warranty of
 #  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 #  GNU General Public License for more details.
 #
 #  You should have received a copy of the GNU General Public License
 #  along with LogiSima.  If not, see <http://www.gnu.org/licenses/>.
###

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

