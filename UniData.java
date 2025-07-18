// UniData.java


public class UniData {
    private String rank2024;
    private String rank2023;
    private String institutionName;
    private String countryCode;
    private String country;
    private String size;
    private String focus;
    private String research;
    private String age;
    private String status;
    private String academicRepScore;
    private String academicRepRank;
    private String employerRepScore;
    private String employerRepRank;
    private String facultyStudentScore;
    private String facultyStudentRank;
    private String citationsScore;
    private String citationsRank;
    private String intlFacultyScore;
    private String intlFacultyRank;
    private String intlStudentsScore;
    private String intlStudentsRank;
    private String intlResearchScore;
    private String intlResearchRank;
    private String employmentScore;
    private String employmentRank;
    private String sustainabilityScore;
    private String sustainabilityRank;
    private String overallScore;
    
    // Constructor
    public UniData(String rank2024, String rank2023, String institutionName,
                   String countryCode, String country, String size, String focus,
                   String research, String age, String status, String academicRepScore,
                   String academicRepRank, String employerRepScore, String employerRepRank,
                   String facultyStudentScore, String facultyStudentRank, String citationsScore,
                   String citationsRank, String intlFacultyScore, String intlFacultyRank,
                   String intlStudentsScore, String intlStudentsRank, String intlResearchScore,
                   String intlResearchRank, String employmentScore, String employmentRank,
                   String sustainabilityScore, String sustainabilityRank, String overallScore) {
        this.rank2024 = rank2024;
        this.rank2023 = rank2023;
        this.institutionName = institutionName;
        this.countryCode = countryCode;
        this.country = country;
        this.size = size;
        this.focus = focus;
        this.research = research;
        this.age = age;
        this.status = status;
        this.academicRepScore = academicRepScore;
        this.academicRepRank = academicRepRank;
        this.employerRepScore = employerRepScore;
        this.employerRepRank = employerRepRank;
        this.facultyStudentScore = facultyStudentScore;
        this.facultyStudentRank = facultyStudentRank;
        this.citationsScore = citationsScore;
        this.citationsRank = citationsRank;
        this.intlFacultyScore = intlFacultyScore;
        this.intlFacultyRank = intlFacultyRank;
        this.intlStudentsScore = intlStudentsScore;
        this.intlStudentsRank = intlStudentsRank;
        this.intlResearchScore = intlResearchScore;
        this.intlResearchRank = intlResearchRank;
        this.employmentScore = employmentScore;
        this.employmentRank = employmentRank;
        this.sustainabilityScore = sustainabilityScore;
        this.sustainabilityRank = sustainabilityRank;
        this.overallScore = overallScore;
    }
    
    // Parse CSV line to UniData object
    public static UniData fromCSV(String csvLine) {
        String[] fields = csvLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        
        // Handle cases where there might be fewer than 29 fields
        while (fields.length < 29) {
            String[] newFields = new String[fields.length + 1];
            System.arraycopy(fields, 0, newFields, 0, fields.length);
            newFields[fields.length] = "";
            fields = newFields;
        }
    
        // Remove quotes if present
        for (int i = 0; i < fields.length; i++) {
            // Lab2-Part1.2
            if("".equals(fields[i])){ 
                fields[i] = "0";
            }
            fields[i] = fields[i].replaceAll("^\"|\"$", "").trim();
        }
        // Lab2-Part1.3
        for(int i = 10; i < fields.length; i++) { 
            try {
                double doubleNum = Double.parseDouble(fields[i]);
                double roundedNum = Math.round(doubleNum);
                fields[i] = String.valueOf(roundedNum);
            } catch (NumberFormatException e) {
                fields[i] = "0";
            }
        }

        return new UniData(
            fields[0], fields[1], fields[2], fields[3], fields[4],
            fields[5], fields[6], fields[7], fields[8], fields[9],
            fields[10], fields[11], fields[12], fields[13], fields[14],
            fields[15], fields[16], fields[17], fields[18], fields[19],
            fields[20], fields[21], fields[22], fields[23], fields[24],
            fields[25], fields[26], fields[27], fields[28]
        );
    }
    
    // Convert to CSV format
    public String toCSV() {
        return String.join(",",
            quote(rank2024), quote(rank2023), quote(institutionName),
            quote(countryCode), quote(country), quote(size), quote(focus),
            quote(research), quote(age), quote(status), quote(academicRepScore),
            quote(academicRepRank), quote(employerRepScore), quote(employerRepRank),
            quote(facultyStudentScore), quote(facultyStudentRank), quote(citationsScore),
            quote(citationsRank), quote(intlFacultyScore), quote(intlFacultyRank),
            quote(intlStudentsScore), quote(intlStudentsRank), quote(intlResearchScore),
            quote(intlResearchRank), quote(employmentScore), quote(employmentRank),
            quote(sustainabilityScore), quote(sustainabilityRank), quote(overallScore)
        );
    }
    
    // Helper method to quote fields if they contain commas
    private String quote(String field) {
        if (field == null) 
            field = "";
        if (field.contains(",") || field.contains("\"") || field.contains("\n")) {
            return "\"" + field.replace("\"", "\"\"") + "\"";
        }
        return field;
    }
    
    // Getters (add as needed)
    public String getInstitutionName() {
        return institutionName;
    }
    
    public String getCountry() {
        return country;
    }
}