all:
	@$(MAKE) -C src all

clean:
	@$(MAKE) -C src clean

fclean:
	@$(MAKE) -C src fclean

re:
	@$(MAKE) -C src re

run:
	@$(MAKE) -C src run

test:
	@$(MAKE) -C src test

readme:
	./doc/build-readme.sh


.PHONY: all clean fclean re run
