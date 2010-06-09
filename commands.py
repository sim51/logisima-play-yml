# Here you can create play commands that are specific to the module

# Example below:
# ~~~~
if play_command == 'logisima-play-yml:hello':
	try:
		print "~ Hello from logisima-play-yml"
		sys.exit(0)
				
	except getopt.GetoptError, err:
		print "~ %s" % str(err)
		print "~ "
		sys.exit(-1)
		
	sys.exit(0)
