class TeamMember(val memberName: String) : TeamComponent {


    override fun calculateTheAmount() {
        print(memberName)
    }
}