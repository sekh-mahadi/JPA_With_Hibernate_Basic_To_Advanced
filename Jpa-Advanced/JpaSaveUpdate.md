       
        ## Savae and Update method
        //Insert and Update
	...public Course save(Course course) {
		if (course.getId() == null) {
			// insert Course
			eManager.persist(course);
		} else {
			eManager.merge(course);
		}
		return course;
	}...
	
	### Save and Update Method Test
	
     ...@Test
	@DirtiesContext
	public void save_Basic() {
		// get a Course
		Course course = repo.findById(100002l);
		assertEquals("Spring Advanced", course.getName());

		// update details
		course.setName("Spring Advanced - updated");
		repo.save(course);
		// Check the value
		Course course1 = repo.findById(100002l);
		assertEquals("Spring Advanced - updated", course1.getName());

	}...
