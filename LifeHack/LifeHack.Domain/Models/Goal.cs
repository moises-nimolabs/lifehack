using Newtonsoft.Json;
using System.Collections.Generic;

namespace LifeHack.Domain.Models
{
    public class Goal : Entity
    {
        [JsonProperty("name")]
        public string Name { get; set; }
        [JsonProperty("goals")]
        public List<Goal> Goals { get; set; }
    }
}
