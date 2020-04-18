
class TeamComposite : TeamComponent {

    var listOfMembers = mutableListOf<TeamComponent>()

    var sum: Double = 0.0

    override fun calculateTheAmount() {
        for (member in listOfMembers) {
            member.calculateTheAmount()
        }
    }

    fun addMemer(newMember: TeamComponent) {
        listOfMembers.add(newMember)
    }

    fun  removeMember(memberName: TeamComponent) {
        listOfMembers.remove(memberName)
    }
}